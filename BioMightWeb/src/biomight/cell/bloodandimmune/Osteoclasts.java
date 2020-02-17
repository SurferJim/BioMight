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
public class Osteoclasts {
	private ArrayList osteoclasts;
	
	/*
	 * Create default Thymocytes
	 */
	public Osteoclasts() {
	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public Osteoclasts(int numReticulocytes) {
		osteoclasts = new ArrayList();
		
		for (int i=0; i<numReticulocytes; i++)
		{
			Osteoclast osteoclast = new Osteoclast();
			osteoclasts.add(i, osteoclast);
		}
			
	}
}
