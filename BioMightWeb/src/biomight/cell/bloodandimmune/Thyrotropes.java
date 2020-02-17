/*
 * Created on Oct 25, 2006
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
public class Thyrotropes {

	private ArrayList thyrotropes;
	
	/*
	 * Create default Thymocytes
	 */
	public Thyrotropes() {

	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public Thyrotropes(int numThymocytes) {
		thyrotropes = new ArrayList();
		
		for (int i=0; i<numThymocytes; i++)
		{
			Thyrotrope thyrotrope = new Thyrotrope();
			thyrotropes.add(i, thyrotrope);
		}
			
	}

}
