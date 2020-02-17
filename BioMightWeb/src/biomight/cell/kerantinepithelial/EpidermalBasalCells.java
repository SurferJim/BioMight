/*
 * Created on Apr 25, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.kerantinepithelial;
import java.util.ArrayList;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class EpidermalBasalCells {
	private ArrayList epidermalBasalCells;
	
	/*
	 * Create default Thymocytes
	 */
	public EpidermalBasalCells() {

	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public EpidermalBasalCells(int numEpidermalBasalCells) {
		epidermalBasalCells = new ArrayList();
		
		for (int i=0; i<numEpidermalBasalCells; i++)
		{
			EpidermalBasalCell epidermalBasalCell = new EpidermalBasalCell();
			epidermalBasalCells.add(i, epidermalBasalCell);
		}
			
	}

}
