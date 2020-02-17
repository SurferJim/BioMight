/*
 * Created on May 21, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.view;

import java.io.Serializable;

import javax.persistence.Entity;

import biomight.Constants;


/*********************************************************
 * @author SurferJim
 *
 * Representation for a Transform Object or Component
 * 
 *********************************************************/

@Entity
public class BioMightTransform implements Serializable {
	
	// Primary Identifiers
	private int bodyID = 1;
	private int projectID = 1;
	private String componentID = "1";
	private String parentID = "";
	private String componentType = "";
	private String componentName = "";
	
	private BioMightPosition translation;
	private BioMightScale scale;
	private BioMightOrientation orientation;
	private BioMightMaterial material;
	private int materialID;
	
	private int textureID = 0;
	private String textureName;
	private String textureFile;
	
	private BioMightPositions coordpoint;
	private BioMightPositions boundBox;
	private int[] coordIndex;
	private double creaseAngle;	
	private double radius;
	private double height;
	private double depth;
	private int depthDirection;
	private String X3D = "";
	private String bioText = "BioMight X3D";
	
	private BioMightText bioMightText;
	private int textID = 0;	
	
	public int getDepthDirection() {
		return depthDirection;
	}


	public void setDepthDirection(int depthDirection) {
		this.depthDirection = depthDirection;
	}


	// Allocate the Coordinate-Index Array for Polygon
	/*
	private int polyInd[] = {
		    3, 2, 1, 0, -1, 
		    2, 6, 5, 1, -1,
		    6, 7, 4, 5, -1,
		    7, 3, 0, 4, -1,
		    0, 1, 5, 4, -1,
		    7, 6, 2, 3, -1};
	 */
	private int polyInd[] = {
		    3, 2, 1, 0, -1};
		
	
	private int triangleIndex[] = { 
			0, 2, 1, -1,  
			0, 3, 2, -1,
			0, 4, 3, -1,
			0, 5, 4, -1,
			0, 1, 5, -1};
	
	
	public BioMightTransform() {
		translation = new BioMightPosition();
		scale = new BioMightScale("1.0, 1.0, 1.0");
		orientation = new BioMightOrientation("0.0, 1.0, 0.0, 0.0");
		material = new BioMightMaterial();
		materialID = 7;
		bioMightText = new BioMightText();
		textID=0;
		
		textureID = 0;
		textureName = "";
		textureFile = "";
		

		
		// Set up the Coordinate points that assemble a quadilateral
		coordpoint = new BioMightPositions();
		BioMightPosition bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
		coordpoint.addBioMightPosition(0, bioMightPosition);
		bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
		coordpoint.addBioMightPosition(1, bioMightPosition);
		bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
		coordpoint.addBioMightPosition(2, bioMightPosition);
		bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
		coordpoint.addBioMightPosition(3, bioMightPosition);
		
		// Set up the default Bound Box points
		boundBox = new BioMightPositions();
		bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
		boundBox.addBioMightPosition(0, bioMightPosition);
		bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
		boundBox.addBioMightPosition(1, bioMightPosition);
		bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
		boundBox.addBioMightPosition(2, bioMightPosition);
		bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
		boundBox.addBioMightPosition(3, bioMightPosition);
		
		// Set up the Index points
		setCoordIndex(polyInd);
		//System.out.println("Stored CoordIndex: " + getCoordindexStr());
	}

	
	
	/************************************************************************************************
	 *  BIOMIGHT TRANSFORM CONSTRUCTOR
	 *  
	 * **********************************************************************************************/
	
	public BioMightTransform(int bodyIDIn, int projectIDIn, String componentIDIn, String componentTypeIn, String componentNameIn, String parentIDIn) {
		bodyID = bodyIDIn;
		projectID = projectIDIn;
		componentID = componentIDIn;
		componentType = componentTypeIn;
		componentName = componentNameIn;
		parentID = parentIDIn;
			
		translation = new BioMightPosition();
		scale = new BioMightScale("1.0, 1.0, 1.0");
		orientation = new BioMightOrientation("1.0, 1.0, 1.0, 1.0");
		
		material = new BioMightMaterial();
		materialID = 7;
		
		textureID = 0;
		textureName="";
		textureFile = "";
		
		bioMightText = new BioMightText();
		textID= 7;
		
		// Set up the Coordinate Box points
		coordpoint = new BioMightPositions();
		BioMightPosition bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
		coordpoint.addBioMightPosition(0, bioMightPosition);
		bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
		coordpoint.addBioMightPosition(1, bioMightPosition);
		bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
		coordpoint.addBioMightPosition(2, bioMightPosition);
		bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
		coordpoint.addBioMightPosition(3, bioMightPosition);
		
	
		// Set up the default Bound Box points
		boundBox = new BioMightPositions();
		bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
		boundBox.addBioMightPosition(0, bioMightPosition);
		bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
		boundBox.addBioMightPosition(1, bioMightPosition);
		bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
		boundBox.addBioMightPosition(2, bioMightPosition);
		bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
		boundBox.addBioMightPosition(3, bioMightPosition);
		
		setCoordIndex(polyInd);
		//System.out.println("Stored CoordIndex: " + getCoordindexStr());
	}

	/************************************************************************************************
	 *  BIOMIGHT TRANSFORM CONSTRUCTOR - Get shape parameter
	 * 
	 * 
	 * **********************************************************************************************/
	
	public BioMightTransform(int shape, int bodyIDIn, int projectIDIn, String componentIDIn, String componentTypeIn, String componentNameIn, String parentIDIn) {
		
		// Load into object properties
		bodyID = bodyIDIn;
		projectID = projectIDIn;
		componentID = componentIDIn;
		componentType = componentTypeIn;
		componentName = componentNameIn;
		parentID = parentIDIn;
			
		translation = new BioMightPosition();
		scale = new BioMightScale("1.0, 1.0, 1.0");
		orientation = new BioMightOrientation("1.0, 1.0, 1.0, 1.0");
		
		material = new BioMightMaterial();
		materialID = 7;
		
		textureID = 0;
		textureName="";
		textureFile = "";

		bioMightText = new BioMightText();
		textID= 7;
		
		// Set up the Coordinate Box points
		coordpoint = new BioMightPositions();
		
		BioMightPosition bioMightPosition = null;
		// 
		if (shape == Constants.QUADRANGLE) {
			
			bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
			coordpoint.addBioMightPosition(0, bioMightPosition);
			
			bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
			coordpoint.addBioMightPosition(1, bioMightPosition);
			
			bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
			coordpoint.addBioMightPosition(2, bioMightPosition);
			
			bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
			coordpoint.addBioMightPosition(3, bioMightPosition);
			
			setCoordIndex(polyInd);
			//System.out.println("Stored CoordIndex: " + getCoordindexStr());
		}
		else if (shape == Constants.TRIANGLE) 
		{
			bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
			coordpoint.addBioMightPosition(0, bioMightPosition);
			
			bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
			coordpoint.addBioMightPosition(1, bioMightPosition);
			
			bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
			coordpoint.addBioMightPosition(2, bioMightPosition);
			
			setCoordIndex(triangleIndex);
			//System.out.println("Stored CoordIndex: " + getCoordindexStr());
		}
		
		// Set up the default Bound Box points
		boundBox = new BioMightPositions();
		bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
		boundBox.addBioMightPosition(0, bioMightPosition);
		bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
		boundBox.addBioMightPosition(1, bioMightPosition);
		bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
		boundBox.addBioMightPosition(2, bioMightPosition);
		bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
		boundBox.addBioMightPosition(3, bioMightPosition);
	}
	
	/**************************************************************************
	 * SET COORDINATE POINT
	 * 
	 * 
	 * @return
	 *************************************************************************/
	
	public void setCoordpoint(String coordStr, double depth, int depthDirection) {
		
		
		if (coordStr==null){
			//System.out.println("BAD Coordinates")
			return;
		}
		if (coordStr.length() < 3) {
			//System.out.println("BAD Coordinates");
			return;
		}
	
		// System.out.println("Storing CoordPoints: " + coordStr);
		String[] coords = coordStr.split(",", 24);
		//System.out.println("Using Depth: " + depth); 
		
		// Store the Coordinate Points in BioMightPosition objects
		int j=0;
		for (int i=0;i<=11;i+=3)
		{
			BioMightPosition vertex = new BioMightPosition();
			
			vertex.setXPos(Double.valueOf(coords[i]));
			vertex.setYPos(Double.valueOf(coords[i+1]));
			vertex.setZPos(Double.valueOf(coords[i+2]));
			//System.out.println("Storing Coordinates: " + j +    "  x: " + coords[i] + " y: " + coords[i+1] + " z: " + coords[i+2]);	
			coordpoint.setBioMightPosition(j++, vertex);
		}
		
		//System.out.println("Stored CoordPoints!");
	}


	/**************************************************************************
	 * SET COORDINATE POINT WALLED
	 * 
	 * 
	 * @return
	 *************************************************************************/
	
	public void setCoordpointWalled(String coordStr, double depth, int depthDirection) {
		
		
		if (coordStr==null){
			//System.out.println("BAD Coordinates")
			return;
		}
		if (coordStr.length() < 3) {
			//System.out.println("BAD Coordinates");
			return;
		}
	
		// System.out.println("Storing CoordPoints: " + coordStr);
		String[] coords = coordStr.split(",", 24);
		//System.out.println("Using Depth: " + depth); 
		
		// Store the Coordinate Points in BioMightPosition objects
		int j=0;
		for (int i=0;i<=11;i+=3)
		{
			BioMightPosition vertex = new BioMightPosition();
			
			vertex.setXPos(Double.valueOf(coords[i]));
			vertex.setYPos(Double.valueOf(coords[i+1]));
			vertex.setZPos(Double.valueOf(coords[i+2]));
			//System.out.println("Storing Coordinates: " + j +    "  x: " + coords[i] + " y: " + coords[i+1] + " z: " + coords[i+2]);	
			coordpoint.setBioMightPosition(j++, vertex);
		}
		
		// Store the lower plane
		// Use the Depth Direction,0,90,180,270 to see where we are
		for (int i=0;i<=11;i+=3)
		{
			BioMightPosition vertex = new BioMightPosition();
		
			if (depthDirection == 0) {
				vertex.setXPos(Double.valueOf(coords[i]));
				vertex.setYPos(Double.valueOf(coords[i+1]));
				vertex.setZPos(Double.valueOf(coords[i+2])-depth);
			}		
			else if (depthDirection == 90) {
				vertex.setXPos(Double.valueOf(coords[i])-depth);
				vertex.setYPos(Double.valueOf(coords[i+1]));
				vertex.setZPos(Double.valueOf(coords[i+2]));
			}
			else if (depthDirection == 180) {
				vertex.setXPos(Double.valueOf(coords[i]));
				vertex.setYPos(Double.valueOf(coords[i+1]));
				vertex.setZPos(Double.valueOf(coords[i+2])+depth);
			}
			else if (depthDirection == 270) {
				vertex.setXPos(Double.valueOf(coords[i])+depth);
				vertex.setYPos(Double.valueOf(coords[i+1]));
				vertex.setZPos(Double.valueOf(coords[i+2]));
			}			
			else {
				vertex.setXPos(Double.valueOf(coords[i]));
				vertex.setYPos(Double.valueOf(coords[i+1]));
				vertex.setZPos(Double.valueOf(coords[i+2])-depth);
			}
			
			//System.out.println("Storing BackPlane Coordinates: " + j +    "  x: " + coords[i] + " y: " + coords[i+1] + " z: " + coords[i+2]);	
			coordpoint.setBioMightPosition(j++, vertex);
		}		

		//System.out.println("Stored CoordPoints!");
	}

	
	/********************************************************************************
	 * SET COORDINATE POINT
	 * 
	 * This method take the String of X3D coordinates and loads them into the
	 * coodinate Points array.
	 * @return
	 ********************************************************************************/
	
	public void setCoordpoint(int shape, String coordStr, double depth, int depthDirection) {
		
		
		if (coordStr==null){
			//System.out.println("BAD Coordinates")
			return;
		}
		if (coordStr.length() < 3) {
			//System.out.println("BAD Coordinates");
			return;
		}
	
		String[] coords = null;
		
		if (shape == Constants.TRIANGLE) 
		{
			//System.out.println("Storing CoordPoints: " + coordStr);	
			coords = coordStr.split(",", 18);
			//System.out.println("Using Depth: " + depth); 
		}
		else if (shape == Constants.QUADRANGLE)
		{
			//System.out.println("Storing CoordPoints: " + coordStr);	
			coords = coordStr.split(",", 24);
			//System.out.println("Using Depth: " + depth); 
		}
		else if (shape == Constants.PENTAGON) {
			//System.out.println("Storing CoordPoints: " + coordStr);	
			coords = coordStr.split(",", 30);
			//System.out.println("Using Depth: " + depth); 
		}			
		else if (shape == Constants.HEXAGON) {
			//System.out.println("Storing CoordPoints: " + coordStr);	
			coords = coordStr.split(",", 36);
			//System.out.println("Using Depth: " + depth); 
		}		
		
		
		// Store the Coordinate Points in BioMightPosition objects
		// There is an (x y z) for each point orientating it into 3D space
		// As we loop through the points we take 3 at a time
		int j=0;
		int numIterations = shape * 3 - 1; 
		for (int i=0;i<=numIterations;i+=3)
		{
			BioMightPosition vertex = new BioMightPosition();
			
			vertex.setXPos(Double.valueOf(coords[i]));
			vertex.setYPos(Double.valueOf(coords[i+1]));
			vertex.setZPos(Double.valueOf(coords[i+2]));
			//System.out.println("Storing Coordinates: " + j +    "  x: " + coords[i] + " y: " + coords[i+1] + " z: " + coords[i+2]);	
			coordpoint.setBioMightPosition(j++, vertex);
		}
		
		// Store the lower plane
		// Use the Depth Direction,0,90,180,270 to see where we are
		for (int i=0;i<=numIterations;i+=3)
		{
			BioMightPosition vertex = new BioMightPosition();
		
			if (depthDirection == 0) {
				vertex.setXPos(Double.valueOf(coords[i]));
				vertex.setYPos(Double.valueOf(coords[i+1]));
				vertex.setZPos(Double.valueOf(coords[i+2])-depth);
			}		
			else if (depthDirection == 90) {
				vertex.setXPos(Double.valueOf(coords[i])-depth);
				vertex.setYPos(Double.valueOf(coords[i+1]));
				vertex.setZPos(Double.valueOf(coords[i+2]));
			}
			else if (depthDirection == 180) {
				vertex.setXPos(Double.valueOf(coords[i]));
				vertex.setYPos(Double.valueOf(coords[i+1]));
				vertex.setZPos(Double.valueOf(coords[i+2])+depth);
			}
			else if (depthDirection == 270) {
				vertex.setXPos(Double.valueOf(coords[i])+depth);
				vertex.setYPos(Double.valueOf(coords[i+1]));
				vertex.setZPos(Double.valueOf(coords[i+2]));
			}			
			else {
				vertex.setXPos(Double.valueOf(coords[i]));
				vertex.setYPos(Double.valueOf(coords[i+1]));
				vertex.setZPos(Double.valueOf(coords[i+2])-depth);
			}
			
			//System.out.println("Storing BackPlane Coordinates: " + j +    "  x: " + coords[i] + " y: " + coords[i+1] + " z: " + coords[i+2]);	
			coordpoint.setBioMightPosition(j++, vertex);
		}		

		//System.out.println("Stored CoordPoints!");
	}
	

	
	/**************************************************************************
	 * SET BOUNDBOX
	 * mi
	 * Takes the 8 coordinates from the database and uses them to construct
	 * the bound box based on BioMightPosition objects.  
	 * 
	 * @return
	 *************************************************************************/
	
	public void setBoundBox(String bbStr) {
		
		if (bbStr==null){
			//System.out.println("BAD Coordinates")
			return;
		}
		if (bbStr.length() < 3) {
			//System.out.println("BAD Coordinates");
			return;
		}
	
		//System.out.println("Storing CoordPoints: " + coordStr);
		
		String[] coords = bbStr.split(",", 48);
		//System.out.println("Split up BBCoords: " + bbStr + "   elems : " + coords.length);
				
		// Store the Coordinate Points in BioMightPosition objects
		int j=0;
		for (int i=0;i<=11;i+=3)
		{
			BioMightPosition vertex = new BioMightPosition();
			
			vertex.setXPos(Double.valueOf(coords[i]));
			vertex.setYPos(Double.valueOf(coords[i+1]));
			vertex.setZPos(Double.valueOf(coords[i+2]));
			//System.out.println("Storing BoundBox Point: " + j +    "  x: " + coords[i] + " y: " + coords[i+1] + " z: " + coords[i+2]);	
			boundBox.setBioMightPosition(j++, vertex);
		}
		
		//System.out.println("Stored BoundBox Points!");
	}
	
	/**************************************************************************
	 * GET COORDINATE POINTS AS STRING
	 * 
	 * This method extracts the data from the coordpoint array and builds
	 * a string representation that can be given to the X3D engine
	 * for construction
	 * 
	 * @return
	 *************************************************************************/
	
	public BioMightPosition getCoordinateZero() {
		//System.out.println("Extracting Coordinate 0: " + coordpoint.getSize());

		BioMightPosition vertex = coordpoint.getBioMightPosition(0);
		return vertex;
	}
	
	/**************************************************************************
	 * GET COORDINATE POINTS AS STRING
	 * 
	 * This method extracts the data from the coordpoint array and builds
	 * a string representation that can be given to the X3D engine
	 * for construction
	 * 
	 * @return
	 *************************************************************************/
	
	public String getCoordpointStr() {
		
		// Set up a string var to hold the extracted coordinates
		String coordStr = new String();

		//System.out.println("Extracting CoordPoints: " + coordpoint.getSize());
		// Get the verticies from the BioMightPosition objects
		for (int i=0;i<coordpoint.getSize();i++)
		{
			BioMightPosition vertex = coordpoint.getBioMightPosition(i);
			//System.out.println("Extracting CoordPoint for : " + i);
			if (i==0)
			{
				coordStr += vertex.getXPos() + "," + vertex.getYPos() + "," + vertex.getZPos();
			}
			else
			{
				coordStr += "," + vertex.getXPos() + "," + vertex.getYPos() + "," + vertex.getZPos();
			}
			//System.out.println("Reverse Coordinates: " + coordStr);
		}

		return coordStr;
	}
	
	/**************************************************************************
	 * GET BOUNDBOX POINTS AS STRING
	 * 
	 * Takes the 8 coordinates from the database and uses them to construct
	 * the bound box based on BioMightPosition objects.  
	 * 
	 * @return
	 *************************************************************************/

	public String getBoundBoxStr() {
		
		// Set up a string var to hold the extracted coordinates
		String bbStr = new String();

		//System.out.println("Extracting CoordPoints: " + coordpoint.getSize());
		// Get the verticies from the BioMightPosition objects
		for (int i=0;i<boundBox.getSize();i++)
		{
			BioMightPosition vertex = boundBox.getBioMightPosition(i);
			//System.out.println("Extracting CoordPoint for : " + i);
			if (i==0)
			{
				bbStr += vertex.getXPos() + "," + vertex.getYPos() + "," + vertex.getZPos();
			}
			else
			{
				bbStr += "," + vertex.getXPos() + "," + vertex.getYPos() + "," + vertex.getZPos();
			}
			//System.out.println("Reverse Coordinates: " + coordStr);
		}

		return bbStr;
	}
	

	public BioMightScale getScale() {
		return scale;
	}


	public String getScaleStr() {
		return scale.getScaleStrWC();
	}
	
	public void setScale(BioMightScale scale) {
		this.scale = scale;
	}


	public String getTranslationStr() {
		return translation.getPositionStrWC();
	}


	public String getOrientationStr() {
		return orientation.getOrientationStrWC();
	}
	
	
	public BioMightMaterial getMaterial() {
		return material;
	}


	public void setMaterial(BioMightMaterial material) {
		this.material = material;
	}


	public double getRadius() {
		return radius;
	}


	public void setRadius(double radius) {
		this.radius = radius;
	}


	public BioMightPosition getTranslation() {
		return translation;
	}


	public void setTranslation(BioMightPosition translation) {
		this.translation = translation;
	}

	
	public String getName() {
		return componentName;
	}
	
	public String getId() {
		return componentID;
	}

	public String getComponentID() {
		return componentID;
	}

	public void setComponentID(String id) {
		this.componentID = id;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String name) {
		this.componentName = name;
	}

	public double getCreaseAngle() {
		return creaseAngle;
	}


	
	public void setCoordpoint(BioMightPositions coordpoint) {
		this.coordpoint = coordpoint;
	}

	public void setBoundBox(BioMightPositions boundBox) {
		this.boundBox = boundBox;
	}
	
	public void setCreaseAngle(double creaseAngle) {
		this.creaseAngle = creaseAngle;
	}

	
	public String getCoordindexStr() {

		//System.out.println("Extracting Coordinates Index" + coordIndex.length);
		String indexStr = new String();
		
		for (int i=0;i<coordIndex.length;i++)
		{
			//System.out.println("Extracting Coordinates for : " + i);
			if (i==0)
			{
				indexStr+= coordIndex[i];
			}
			else
			{
				indexStr+= "," + coordIndex[i];
			}	
			//System.out.println("Indicies: " + indexStr);
		}
		
		return indexStr;
	}

	
	public int[] getCoordIndex() {
		return coordIndex;
	}


	public void setCoordIndex(int[] coordIndex) {
		this.coordIndex = coordIndex;
	}


	public double getDepth() {
		return depth;
	}


	public void setDepth(double depth) {
		this.depth = depth;
	}


	public int getMaterialID() {
		return materialID;
	}


	public void setMaterialID(int materialID) {
		this.materialID = materialID;
	}


	public int getTextureID() {
		return textureID;
	}


	public void setTextureID(int textureID) {
		this.textureID = textureID;
	}

	

	public String getTextureName() {
		return textureName;
	}


	public void setTextureName(String textureName) {
		this.textureName = textureName;
	}


	public String getTextureFile() {
		return textureFile;
	}


	public void setTextureFile(String textureFile) {
		this.textureFile = textureFile;
	}


	public String getX3D() {
		return X3D;
	}


	public void setX3D(String x3d) {
		X3D = x3d;
	}


	public String getBioText() {
		return bioText;
	}


	public void setBioText(String bioText) {
		this.bioText = bioText;
	}


	public int getBodyID() {
		return bodyID;
	}


	public void setBodyID(int bodyID) {
		this.bodyID = bodyID;
	}


	public String getParentID() {
		return parentID;
	}


	public void setParentID(String parentID) {
		this.parentID = parentID;
	}


	public String getComponentType() {
		return componentType;
	}


	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}


	public int getProjectID() {
		return projectID;
	}


	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}


	public BioMightPositions getCoordpoint() {
		return coordpoint;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public BioMightOrientation getOrientation() {
		return orientation;
	}


	public void setOrientation(BioMightOrientation orientation) {
		this.orientation = orientation;
	}


	public BioMightText getBioMightText() {
		return bioMightText;
	}


	public void setBioMightText(BioMightText bioMightText) {
		this.bioMightText = bioMightText;
	}


	public int getTextID() {
		return textID;
	}


	public void setTextID(int textID) {
		this.textID = textID;
	}
			
	
	
	
}