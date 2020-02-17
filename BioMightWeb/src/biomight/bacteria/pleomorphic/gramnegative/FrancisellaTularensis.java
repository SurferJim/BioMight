/*
 * Created on Oct 13, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.bacteria.pleomorphic.gramnegative;
import biomight.bacteria.BacterialCell;
import biomight.chemistry.pharma.antimicrobial.*;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class FrancisellaTularensis extends BacterialCell {

	
	
	public FrancisellaTularensis()
	{
		setImage("images/FrancisellaTularensis.jpg");
	}

	
	public void onContact(Object obj)
	{	
		if (obj instanceof Streptomycin)
		{
			// Dysentery
		}
	}



}
