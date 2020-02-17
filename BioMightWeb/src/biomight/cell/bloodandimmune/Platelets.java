/*
 * Created on Jun 11, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.bloodandimmune;
import java.util.ArrayList;


/**
 * 
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class Platelets {
	private ArrayList platelets;
	

	public Platelets() {

	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public Platelets(int numLymphocytes) {
		platelets = new ArrayList();
		
		for (int i=0; i<numLymphocytes; i++)
		{
			Platelet platelet = new Platelet();
			platelets.add(i, platelet);
		}
			
	}
}
