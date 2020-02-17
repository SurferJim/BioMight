/*
 * Created on Apr 28, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.pigment;
import java.util.ArrayList;

/**
 * @author SurferJim
 *
 * Create a group of melanocytes and distribute into tissue
 * 
 */

public class Melanocytes {
	private ArrayList melanocytes;
	
	/*
	 *  
	 */
	public Melanocytes() {

	}
		
	/**
	 * Create a bunch of Melanocytes
	 * 
	 */		
	public Melanocytes(int numMelanocytes) {
		melanocytes = new ArrayList();
		
		for (int i=0; i<numMelanocytes; i++)
		{
			Melanocyte melanocyte = new Melanocyte();
			melanocytes.add(i, melanocyte);
		}
	}
}
