/*
 * Created on Sep 26, 2006
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

public class Leukocytes {
	private ArrayList leukocytes;
	

	public Leukocytes() {

	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public Leukocytes(int numMonocytes) {
		leukocytes = new ArrayList();
		
		for (int i=0; i<numMonocytes; i++)
		{
			Leukocyte leukocyte = new Leukocyte();
			leukocytes.add(i, leukocyte);
		}
			
	}
}
