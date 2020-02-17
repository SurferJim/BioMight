/*
 * Created on Jun 11, 2006
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
public class Thrombocytes {

	private ArrayList thrombocytes;
	
	/*
	 * Create default Thymocytes
	 */
	public Thrombocytes() {

	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public Thrombocytes(int numThrombocytes) {
		thrombocytes = new ArrayList();
		
		for (int i=0; i<numThrombocytes; i++)
		{
			Thrombocyte thrombocyte = new Thrombocyte();
			thrombocytes.add(i, thrombocyte);
		}
			
	}

}
