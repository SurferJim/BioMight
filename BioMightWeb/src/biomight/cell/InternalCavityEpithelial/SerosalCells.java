/*
 * Created on Apr 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.InternalCavityEpithelial;
import java.util.ArrayList;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SerosalCells {
	private ArrayList serosalCells;
	
	/*
	 * Create default Thymocytes
	 */
	public SerosalCells() {

	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public SerosalCells(int numSerosalCells) {
		serosalCells = new ArrayList();
		
		for (int i=0; i<numSerosalCells; i++)
		{
			SerosalCell serosalCell = new SerosalCell();
			serosalCells.add(i, serosalCell);
		}
			
	}

}
