/*
 * Created on Dec 11, 2006
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

public class Thymocytes {
	private ArrayList thymocytes;
	
	
	/*
	 * Create default Thymocytes
	 */
	public Thymocytes() {

	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public Thymocytes(int numThymocytes) {
		thymocytes = new ArrayList();
		
		for (int i=0; i<numThymocytes; i++)
		{
			Thymocyte thymocyte = new Thymocyte();
			thymocytes.add(i, thymocyte);
		}
			
	}

}
