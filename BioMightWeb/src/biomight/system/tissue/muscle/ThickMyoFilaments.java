/*
 * Created on May 7, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.tissue.muscle;
import biomight.chemistry.protein.*;
import java.util.ArrayList;


/**
 * @author SurferJim
 *
 * Creates a bunch of Thick Myofilaments
 */

public class ThickMyoFilaments {
	private ArrayList thickMyoFilaments;
	
	/*
	 * Create default Thymocytes
	 */
	public ThickMyoFilaments() {

	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public ThickMyoFilaments(int numFilaments) {
		thickMyoFilaments = new ArrayList();
		
		for (int i=0; i<numFilaments; i++)
		{
			ThickMyoFilament thickMyoFilament = new ThickMyoFilament();
			thickMyoFilaments.add(i, thickMyoFilament);
		}
			
	}

	
}
