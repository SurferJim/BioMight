/*
 * Created on Jun 3, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.epithelial;

import biomight.BioMightBase;
import java.util.ArrayList;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Pedicles extends BioMightBase {	
	private ArrayList pedicles;
	
	/*
	 * Create default Thymocytes
	 */
	public Pedicles() {
	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public Pedicles(int numPedicles) {
		pedicles = new ArrayList();
		
		for (int i=0; i<numPedicles; i++)
		{
			Pedicle pedicle = new Pedicle();
			pedicles.add(i, pedicle);
		}
			
	}
	
	
	
}
