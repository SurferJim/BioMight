/*
 * Created on Apr 28, 2006
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
public class Reticulocytes {
	private ArrayList reticulocytes;
	
	/*
	 * Create default Thymocytes
	 */
	public Reticulocytes() {

	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public Reticulocytes(int numReticulocytes) {
		reticulocytes = new ArrayList();
		
		for (int i=0; i<numReticulocytes; i++)
		{
			Reticulocyte reticulocyte = new Reticulocyte();
			reticulocytes.add(i, reticulocyte);
		}
			
	}
}
