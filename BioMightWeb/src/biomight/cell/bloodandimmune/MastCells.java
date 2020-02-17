/*
 * Created on Apr 28, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.bloodandimmune;
import java.util.ArrayList;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class MastCells {
	private ArrayList mastCells;
	
	
	public MastCells() {
	}
		
	/**
	 * Create a bunch of Mast Cells and distribute them throughout the body
	 * 
	 */		
	public MastCells(int numMastCell) {
		mastCells = new ArrayList();
		
		for (int i=0; i<numMastCell; i++)
		{
			MastCell mastCell = new MastCell();
			mastCells.add(i, mastCell);
		}
			
	}
}
