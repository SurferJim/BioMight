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
 * Create a bunch of Kidney Glomerulus Parietal Cells and distribute them in Kidney
 * 
 */

public class KidneyGlomerulusParietalCells {
	private ArrayList kidneyGlomerulusParietalCells;
	
	/*
	 * Create default Lysosomes
	 */
	public KidneyGlomerulusParietalCells() {

	}
		
	/**
	 * Create a bunch of Kidney Glomerulus Parietal Cells and distribute them in Kidney
	 * 
	 */		
	public KidneyGlomerulusParietalCells(int numCells) {
		kidneyGlomerulusParietalCells = new ArrayList();
		
		for (int i=0; i<numCells; i++)
		{
			KidneyGlomerulusParietalCell kidneyGlomerusParietalCell = new KidneyGlomerulusParietalCell();
			kidneyGlomerulusParietalCells.add(i, kidneyGlomerusParietalCell);
		}	
	}

}
