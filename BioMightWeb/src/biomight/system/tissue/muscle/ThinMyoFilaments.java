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
 * Creates a bunch of Thin Myofilaments
 * 
 */

public class ThinMyoFilaments extends MyoFilament {
	private ArrayList ThinMyoFilaments;
	
		/*
		 * Create default Thymocytes
		 */
		public ThinMyoFilaments() {

		}
		
		/**
		 * Create a bunch of Thin MyoFilaments
		 * 
		 */		
		public ThinMyoFilaments(int numFilaments) {
			ThinMyoFilaments = new ArrayList();
		
			for (int i=0; i<numFilaments; i++)
			{
				ThinMyoFilament ThinMyoFilament = new ThinMyoFilament();
				ThinMyoFilaments.add(i, ThinMyoFilament);
			}
			
		}
}
