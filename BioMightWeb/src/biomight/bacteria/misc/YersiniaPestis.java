/*
 * Created on Oct 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.bacteria.misc;
import biomight.chemistry.pharma.antimicrobial.*;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class YersiniaPestis {
	
	// PolySacchararide Protein Complex
	
	// YOPS
	private YersinaOuterProteins yersinaOuterProteins;


	public void onContact(Object obj)
	{
		
		// Streptomycin kills it
		if (obj instanceof Streptomycin)
		{
			//
		}
		
		// Tetracycline kills it
		if (obj instanceof Tetracycline)
		{
			//
		}		
		
	}

}
