/*
 * Created on Nov 20, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.metabolismstorage;
import java.util.ArrayList;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AdiposeCells {
	private ArrayList adiposeCells;
	
	/*
	 * Create default Thymocytes
	 */
	public AdiposeCells() {

	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public AdiposeCells(int numAdiposeCells) {
		adiposeCells = new ArrayList();
		
		for (int i=0; i<numAdiposeCells; i++)
		{
			AdiposeCell adiposeCell = new AdiposeCell();
			adiposeCells.add(i, adiposeCell);
		}
			
	}
}
