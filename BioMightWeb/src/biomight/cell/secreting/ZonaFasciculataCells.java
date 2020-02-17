/*
 * Created on Nov 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.secreting;
import java.util.ArrayList;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class ZonaFasciculataCells {
	private ArrayList zonaFasciculataCells;
	
	/*
	 * Create default Thymocytes
	 */
	public ZonaFasciculataCells() {

	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public ZonaFasciculataCells(int numZonaFasciculataCells) {
		zonaFasciculataCells = new ArrayList();
		
		for (int i=0; i<numZonaFasciculataCells; i++)
		{
			ZonaFasciculataCell zonaFasciculataCell = new ZonaFasciculataCell();
			zonaFasciculataCells.add(i, zonaFasciculataCell);
		}
			
	}
}
