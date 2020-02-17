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
public class MicroglialCells {
	private ArrayList microglialCells;
	
	/*
	 * Create default Thymocytes
	 */
	public MicroglialCells() {
	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public MicroglialCells(int numMicroglialCells) {
		microglialCells = new ArrayList();
		
		for (int i=0; i<numMicroglialCells; i++)
		{
			MicroglialCell microglialCell = new MicroglialCell();
			microglialCells.add(i, microglialCell);
		}
			
	}
}
