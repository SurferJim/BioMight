/*
 * Created on Jun 10, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.epithelial;
import java.util.ArrayList;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Enterocytes {
	private ArrayList enterocytes;
	
	/*
	 * Create default Thymocytes
	 */
	public Enterocytes() {

	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public Enterocytes(int numEnterocytes) {
		enterocytes = new ArrayList();
		
		for (int i=0; i<numEnterocytes; i++)
		{
			Enterocyte enterocyte = new Enterocyte();
			enterocytes.add(i, enterocyte);
		}
			
	}
}
