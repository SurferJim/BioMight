/*
 * Created on Jun 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.nucleus;
import java.util.ArrayList;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Nucleosomes {
	private ArrayList nucleosomes;
	
	/*
	 * Create default Thymocytes
	 */
	public Nucleosomes() {

	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public Nucleosomes(int numNucleosomes) {
		nucleosomes = new ArrayList();
		
		for (int i=0; i<numNucleosomes; i++)
		{
			Nucleosome nucleosome = new Nucleosome();
			nucleosomes.add(i, nucleosome);
		}
			
	}

}
