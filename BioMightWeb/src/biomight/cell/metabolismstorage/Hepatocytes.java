/*
 * Created on Apr 25, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.metabolismstorage;
import java.util.ArrayList;


/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Hepatocytes {
	private ArrayList hepatocytes;
	
	/*
	 * Create default Thymocytes
	 */
	public Hepatocytes() {

	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public Hepatocytes(int numHepatocytes) {
		hepatocytes = new ArrayList();
		
		for (int i=0; i<numHepatocytes; i++)
		{
			Hepatocyte hepatocyte = new Hepatocyte();
			hepatocytes.add(i, hepatocyte);
		}
			
	}
	


}
