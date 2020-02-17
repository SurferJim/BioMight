/*
 * Created on May 21, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.view;


/**
 * @author SurferJim
 *
 * Representation for a Polygon aka IndexedFacedSet
 * 
 */

public class BioMightPolygon {
	private BioMightPositions coordpoint;
	private int[] coordIndex;
	private BioMightPosition translation;
	private BioMightPosition scale;
	private double creaseAngle;
	private BioMightMaterial material;
	
	
	public BioMightPolygon() {
		translation = new BioMightPosition();
		scale = new BioMightPosition();
		material = new BioMightMaterial();
	}


	public BioMightPosition getScale() {
		return scale;
	}


	public void setScale(BioMightPosition scale) {
		this.scale = scale;
	}


	public BioMightMaterial getMaterial() {
		return material;
	}


	public void setMaterial(BioMightMaterial material) {
		this.material = material;
	}


	public double getCreaseAngle() {
		return creaseAngle;
	}


	public void setRadius(double creaseAngle) {
		this.creaseAngle = creaseAngle;
	}



	public BioMightPosition getTranslation() {
		return translation;
	}


	public void setTranslation(BioMightPosition translation) {
		this.translation = translation;
	}



	public BioMightPositions getCoordpoint() {
		return coordpoint;
	}

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

	public void setCoordpoint(BioMightPositions coordpoint) {
		this.coordpoint = coordpoint;
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
	
		
}
