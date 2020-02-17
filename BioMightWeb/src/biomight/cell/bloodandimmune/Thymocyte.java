/*
 * Created on Dec 11, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.bloodandimmune;
import biomight.chemistry.compound.*;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Thymocyte {

	// Thymocytes will have to interact with several cell surface molecules, 
	// MHC-HLA, to ensure reactivity and specificity

	public void onContact(Object obj)
	{
		if (obj instanceof HumanLeukocyteAntigens)
		{
			// Bind to receptors
		}

		if (obj instanceof MajorHistocompatibilityComplex)
		{
			// Bind to receptors
		}		
		
	}

}
