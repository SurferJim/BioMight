/*
 * Created on Oct 29, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.misc;
import java.util.ArrayList;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Corticotrophs {
	private ArrayList corticotrophs;
	
	/*
	 * Create default Thymocytes
	 */
	public Corticotrophs() {

	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public Corticotrophs(int numCorticotrophs) {
		corticotrophs = new ArrayList();
		
		for (int i=0; i<numCorticotrophs; i++)
		{
			Corticotroph corticotroph = new Corticotroph();
			corticotrophs.add(i, corticotroph);
		}
			
	}

}
