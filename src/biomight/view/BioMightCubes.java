/*
 * Created on May 21, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.view;
import java.util.ArrayList;

/**
 * @author SurferJim
 *
 * Each Component in BioMight resides in one or more cubes space.  The
 * cubes allow us to pinpoint where in the model, the component lies.
 * 
 */
public class BioMightCubes {
	private int abstractionLevel;
	private ArrayList bioMightCubes;

	public void add(BioMightCube bioMightCube){
		bioMightCubes.add(bioMightCube);
	}
	
	/**
	 * @return
	 */
	public int getAbstractionLevel() {
		return abstractionLevel;
	}

	/**
	 * @param i
	 */
	public void setAbstractionLevel(int i) {
		abstractionLevel = i;
	}

}
