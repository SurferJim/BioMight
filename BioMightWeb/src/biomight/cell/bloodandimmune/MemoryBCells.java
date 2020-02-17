/*
 * Created on Nov 12, 2006
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

public class MemoryBCells {
	private ArrayList memoryBCells;
	
	
	public MemoryBCells() {

	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public MemoryBCells(int numMemoryBCells) {
		memoryBCells = new ArrayList();
		
		for (int i=0; i<numMemoryBCells; i++)
		{
			MemoryBCell memoryBCell = new MemoryBCell();
			memoryBCells.add(i, memoryBCell);
		}
			
	}
}
