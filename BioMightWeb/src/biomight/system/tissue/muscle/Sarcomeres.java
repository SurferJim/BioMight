/*
 * Created on May 10, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.tissue.muscle;
import biomight.BioMightBase;
import java.util.ArrayList;

/**
 * @author SurferJim
 *
 * Create a bundle of sacromers
 * 
 */

public class Sarcomeres extends BioMightBase {
	private ArrayList sarcomeres;

	public Sarcomeres()
	{
		this.setImage("images/Sarcomeres.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	}
	
	
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public Sarcomeres(int numSarcomeres) {
		sarcomeres = new ArrayList();
		
		for (int i=0; i<numSarcomeres; i++)
		{
			Sarcomere sarcomere = new Sarcomere();
			sarcomeres.add(i, sarcomere);
		}
			
	}

	
	
}
