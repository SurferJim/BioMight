/*
 * Created on Oct 13, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.mycoplasma;
import biomight.chemistry.compound.*;
import biomight.chemistry.hormones.lipid.*;
import biomight.chemistry.pharma.antimicrobial.*;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class MycoPlasmaPneumoniae {

	private HydrogenPeroxide hydrogenPeroxide;
	private Cholesterol cholesterol;
	
	
	public void onContact(Object obj)
	{
	
		if (obj instanceof Erythromycin)
		{
			// Kill it
		}
		else if (obj instanceof Azithromycin)
		{
			// Kill it
		}

	}
	
	
	public void setHydrogenPeroxide()
	{
	}
	
	
}
