/*
 * Created on Sep 6, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.nucleus;
import java.util.ArrayList;

/**
 * @author SurferJim
 *
 * Create a bunch of Nucluear Pores and distribute them across the nuclear membrane
 * 
 */

public class NuclearPores {
	private ArrayList nuclearPores;
	
	/*
	 * Create default Thymocytes
	 */
	public NuclearPores() {

	}
		
	/**
	 * Create a bunch of Nucluear Pores and distribute them across the nuclear membrane
	 * 
	 */		
	public NuclearPores(int numNuclearPores) {
		nuclearPores = new ArrayList();
		
		for (int i=0; i<numNuclearPores; i++)
		{
			NuclearPore nuclearPore = new NuclearPore();
			nuclearPores.add(i, nuclearPore);
		}
			
	}

}
