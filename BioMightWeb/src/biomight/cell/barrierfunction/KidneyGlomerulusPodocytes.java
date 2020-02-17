/*
 * Created on Nov 10, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.barrierfunction;
import java.util.ArrayList;

/**
 * @author SurferJim
 *
 * Creates a bunch of Peroxisomes and distributes them across the Cell's cytosol
 * 
 */

public class KidneyGlomerulusPodocytes {
	private ArrayList kidneyGlomerulusPodocytes;
	
	/*
	 * Create default Lysosomes
	 */
	public KidneyGlomerulusPodocytes() {

	}
		
	/**
	 * Create a bunch of Peroxisomes and distribute them throughout the cell
	 * 
	 */		
	public KidneyGlomerulusPodocytes(int numCells) {
		kidneyGlomerulusPodocytes = new ArrayList();
		
		for (int i=0; i<numCells; i++)
		{
			KidneyGlomerulusPodocyte kidneyGlomerusPodocyte = new KidneyGlomerulusPodocyte();
			kidneyGlomerulusPodocytes.add(i, kidneyGlomerusPodocyte);
		}	
	}

}
