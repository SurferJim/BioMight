/*
 * Created on Aug 22, 2007
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

public class KuppferCells {
	private ArrayList kuppferCells;
	

	public KuppferCells() {

	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public KuppferCells(int numKuppferCell) {
		kuppferCells = new ArrayList();
		
		for (int i=0; i<numKuppferCell; i++)
		{
			KuppferCell kuppferCell = new KuppferCell();
			kuppferCells.add(i, kuppferCell);
		}
			
	}

}
