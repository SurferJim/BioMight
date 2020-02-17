/*
 * Created on Oct 31, 2006
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

// A typical monoblast is about 12 to 20 µm in diameter
// has a nuclear to cytoplasm ration of 4:1 to 3:1, 
// and, like most myeloid blasts, has a round to oval nucleus 
// with fine chromatin structure. One to four nucleoli are usually visible. 
// The nucleus can be central or eccentric and it can show evidence of indentation or folding.

public class Monoblasts {
	private ArrayList monoblasts;
	

	public Monoblasts() {

	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public Monoblasts(int numMonoblasts) {
		monoblasts = new ArrayList();
		
		for (int i=0; i<numMonoblasts; i++)
		{
			Monoblasts monoblast = new Monoblasts();
			monoblasts.add(i, monoblast);
		}
			
	}


}
